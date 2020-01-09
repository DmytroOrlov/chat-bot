import distage.{ProviderMagnet, Tag}
import izumi.distage.constructors.TraitConstructor

package object livecode {
  def provideCake[R: TraitConstructor, A: Tag](fn: R => A): ProviderMagnet[A] =
    TraitConstructor[R].provider.map(fn)
}
