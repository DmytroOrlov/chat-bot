package livecode

sealed trait Action

object EnterName extends Action

object SaveName extends Action

object ChooseHeroOfTheDay extends Action

object ChooseSweetCoupleOfTheDay extends Action
