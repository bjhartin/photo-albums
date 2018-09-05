# Scala and FP Usage Notes

This file explains the usage of scala idioms, libraries and FP techniques which might be unfamiliar.

## /.scalafmt and sbt plugin `sbt-tpolecat`

  This formats scala code on compilation, leading to fewer meaningless diffs.

## plugin [sbt-tpolecat](https://github.com/DavidGregory084/sbt-tpolecat)

  This adds many useful scala compiler options [described here](https://tpolecat.github.io/2017/04/25/scalac-flags.html)

## [refined](https://github.com/fthomas/refined)

  Refined lets us write more precise types which rule out error conditions
    and provide handy methods for checking them.

    - type PositiveInt = Int Refined Positive
    - type NonEmptyList = List Refined NonEmpty
    - type CreditCardNo = String MatchesRegex ...

  The following _will not compile_:

    - val a: Counter = -1
    - val b: NonEmptyList = List()
    - val c: CreditCardNo = "Joe"

  We can check values with `refineV` which handles errors gracefully.

    ```scala
        val result = Either[String, CreditCardNo] = refineV(input)
    ```
