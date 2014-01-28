# baizen
  [![Build Status](https://travis-ci.org/bostonaholic/baizen.png?branch=master)](https://travis-ci.org/bostonaholic/baizen) [![Dependency Status](https://www.versioneye.com/user/projects/52e839b0ec1375a4ca000372/badge.png)](https://www.versioneye.com/user/projects/52e839b0ec1375a4ca000372)

A Clojure library designed to parse the Bank Administration Institute (BAI) file format.

## Reference Documentation

[BAI Version 2 Specification](http://www.bai.org/Libraries/Site-General-Downloads/Cash_Management_2005.sflb.ashx)

## Usage

```
(require '[baizen.core :as baizen])

(baizen/parse "file.bai")
```

## License

Copyright © 2014 Matthew Boston

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
