# Photo-Albums

This simple project retrieves the details of photo albums from `https://jsonplaceholder.typicode.com/photos` and prints their details to the console.

## Scala usage

On this branch, I'm aiming for a level of Scala usage which seems appropriate given what we've discussed.  I'll detail any interesting idiom/library choices here and explain why I've used them.

I've also commented the code to explain some choices.  Normally I might not write as many comments as I'd prefer to use types (first) and names (second) to clarify.

### Either

At this point, I'm using Either to represent failures.  That will probably change to Task.}

### Specs2

I'm using Specs2 for testing because it should seem pretty familiar.  I would lean on ScalaCheck (property-based testing) more heavily if allowed, although I am relatively new to that.  In a 'Java-ish Scala' environment, the main advantage might be the avoidance of writing test data management code.

### Http4s

I'm using Http4s for its Http client.  On this branch I'm using v0.16 because i uses Scalaz and I think that's what will be familiar.  I'd use a newer Cats-based version if I had the choice.

This choice pushes a couple of other dependencies back to older versions but I'm fine with that since it's a demo.

### Task

I've used Task, which I've seen in your code, but I've used it a bit more; in particular whenever I know something can fail.  I use for-comprehension as well, as I think it's a good thing to introduce when we start to talk about handling failures and wanting to 'fall out' of a stack of things which can fail.

### Circe

I've used Circe, which is a dependency of Http4s, for decoding Json.

I've chosen to use its 'auto derivation' which means it can decode JSON to a case class as long as all its fields have decoders or are themselves case classes.  If this were seen as too magic, I would use Circe's `.parse` method
to get a `Json` object and map it manually (hopefully not!).

### Implicits

I've restricted my use of implicits to one place where it's unavoidable and provides good benefit: the semi-automatic derivation of Json encoders via Circe in `HttpCodecs.scala`.

### scalafmt (build plugin)

Formats Scala code in compilation to reduce diffs.

### tpolecat (build plugin)

Makes for cleaner code by failing compilation on unused imports, args, etc.

