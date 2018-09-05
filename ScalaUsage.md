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

## [http4s](https://github.com/http4s/http4s)

  Http4s is a Scala Http interface which strives to be both minimal and
    purely functional.

## [cats](https://github.com/typelevel/cats)

  Cats is a typelevel.org project akin to Scalaz.  This is a big topic, but
    for this project I've used it because Http4s requires it and because it
    gives me access to useful FP concepts not present in Scala's libs.

## [scalacheck](https://github.com/rickynils/scalacheck)

  Scalacheck provides _property-based testing_, in which we avoid writing
    test data in favor of allowing Scalacheck's `Arbitrary`/`Generator` classes
    to generate hundreds or thousands of permutations of values and checking
    that certain conditions hold for all known values.

  This often uncovers errors we'd miss by manually creating test values.

  I find it useful in testing codecs.

  It's also nice to avoid writing boilerplate test data creation methods which
    can get burdensome, out of sync or imply too much.

  It has, or can derive, generators for most common types.  If needed, one can
  add custom `Arbitrary`/`Generator` instances.

## [circe](https://github.com/circe/circe)

  Circe is a Scala Json library which can derive Json encoders/decoders for
    common types.
