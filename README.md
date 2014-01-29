# baizen - BAI File Parsing

A Clojure library designed to parse the Bank Administration Institute (BAI) file format.

[![Build Status](https://travis-ci.org/bostonaholic/baizen.png?branch=master)](https://travis-ci.org/bostonaholic/baizen)
[![Dependency Status](https://www.versioneye.com/user/projects/52e839b0ec1375a4ca000372/badge.png)](https://www.versioneye.com/user/projects/52e839b0ec1375a4ca000372)

More documentation can be found on the [wiki](https://github.com/bostonaholic/baizen/wiki).

## Reference Documentation

[BAI Version 2 Specification](http://www.bai.org/Libraries/Site-General-Downloads/Cash_Management_2005.sflb.ashx)

## Dependency Information

[Leiningen](https://github.com/technomancy/leiningen/):

```
[baizen "0.1.0"]
```

[Maven](http://maven.apache.org/):

```
<dependency>
  <groupId>baizen</groupId>
  <artifactId>baizen</artifactId>
  <version>0.1.0</version>
</dependency>
```

## Usage

```
(require '[baizen.core :as baizen])

(baizen/parse "file.bai")
```

What's returned from `baizen/parse` is a LazySeq of maps representing
each record in the file.

More documentation can be found on the
[wiki](https://github.com/bostonaholic/baizen/wiki).

## Development

Running the tests:

```
$ lein test
```

(assumes Leiningen 2.x)

## Documentation

More documentation can be found on the [wiki](https://github.com/bostonaholic/baizen/wiki).

## License

Copyright © 2014 Matthew Boston

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
