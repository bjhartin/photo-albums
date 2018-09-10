# Photo-Albums

This simple project retrieves the details of photo albums from `https://jsonplaceholder.typicode.com/photos` and prints their details to the console.

## Scala usage

On this branch, I'm aiming for a level of Scala usage which seems appropriate given what we've discussed.  I'll detail any interesting idiom/library choices here and explain why I've used them.

### Either

At this point, I'm using Either to represent failures.

### Specs2

I'm using Specs2 for testing because it should seem pretty familiar.  I would lean on ScalaCheck (property-based testing) more heavily if allowed, although I am relatively new to that.  In a 'Java-ish Scala' environment, the main advantage might be the avoidance of writing test data management code.

### Http4s

I'm using Http4s for its Http client.  On this branch I'm using v0.16 because i uses Scalaz and I think that's what will be familiar.  I'd use a newer Cats-based version if I had the choice.


