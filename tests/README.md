# Notation3 Tests

Tests exist for [N3 grammar](N3Tests/manifest-parser.ttl), [N3 reasoning](N3Tests/manifest-reasoner.ttl), [extended N3 grammar](N3Tests/manifest-extended.ttl) and relevant [Turtle](TurtleTests/manifest.ttl) features.

All of these tests suites are referenced from [this manifest](manifest.ttl).

# Design

In general, tests are described as Positive or Negative Syntax tests, Evaluation tests, and/or Reason tests.

* Syntax tests simply check that the data can be parsed properly; negative syntax tests should generate an error.
* Evaluation tests check whether the input (`action`) can be parsed into a dataset which is isomorphic to those described in `results`.
* Reason tests invoke the Notation3 reasoner, with various options, and check that the results are isomorphic to those described in `results`.

Tests should be run with an assumed base URI of their associated manifest, either `https://w3c.github.io/N3/tests/N3Tests` or `https://w3c.github.io/N3/tests/TurtleTests`.

## Test status and current-spec conformance

The manifests retain historical tests so that implementations may measure
compatibility with older N3 dialects. Test runners reporting conformance with
the current N3 specification should use `rdft:approval`:

* `rdft:Approved`, `rdft:Proposed`, and unmarked tests are applicable to the
  current test corpus.
* `rdft:Rejected` tests are non-conformance compatibility tests and should be
  reported separately rather than counted as current-spec failures.

In particular, parser-corpus cases that require the legacy explicit
quantifiers `@forAll` and `@forSome` are marked `rdft:Rejected`, because
[explicit N3 quantifiers were removed from the current specification][quantifiers].
The fixtures remain useful for implementations that intentionally support the
historical syntax.

[quantifiers]: https://w3c.github.io/N3/spec/#changes-since-the-team-submission

# Contributing

If you would like to contribute a new test or a fix to an existing test,
please file an [issue](https://github.com/w3c-cg/N3/issues) and/or create a [pull request](https://github.com/w3c-cg/N3/pulls).
