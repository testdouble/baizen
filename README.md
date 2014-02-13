# baizen - BAI File Parsing

A Clojure library designed to parse the Bank Administration Institute (BAI) file format.

[![Build Status](https://travis-ci.org/bostonaholic/baizen.png?branch=master)](https://travis-ci.org/bostonaholic/baizen)
[![Dependency Status](https://www.versioneye.com/user/projects/52e839b0ec1375a4ca000372/badge.png)](https://www.versioneye.com/user/projects/52e839b0ec1375a4ca000372)

More documentation can be found on the [wiki](https://github.com/testdouble/baizen/wiki).

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

from the repl

```
user=> (require '[baizen.core :as baizen])
nil
user=> (baizen/parse "test-resources/BAI-File-From-Bank-Simple.bai")
({:version "2",
  :block-size "080",
  :record-length "80",
  :file-id "1",
  :creation-time "0600",
  :creation-date "051025",
  :receiver-id "55287",
  :sender-id "021000018",
  :record-code "01"}
 {:as-of-date-modifier "",
  :currency-code "",
  :as-of-time "0000",
  :as-of-date "051022",
  :group-status "1",
  :originator-id "021000018",
  :receiver-id "55287",
  :record-code "02"}
 {:funds-type "",
  :item-count "",
  :amount "+00000004060801",
  :type-code "015",
  :currency-code "",
  :customer-account-number "0101999999",
  :record-code "03"}
 {:customer-reference-number "Miami",
  :bank-reference-number "00087829876",
  :funds-type "Z",
  :amount "000000000346685",
  :type-code "175",
  :record-code "16"}
 {:number-of-records "23",
  :account-control-total "000000018798558",
  :record-code "49"}
 {:number-of-records "32",
  :number-of-accounts "2",
  :group-control-total "000000059748918",
  :record-code "98"}
 {:number-of-records "34",
  :number-of-groups "1",
  :file-control-total "000000059748918",
  :record-code "99"})
nil
```

from your project

```
(ns my.domain.core
  (:require [baizen.core :as :baizen]))
  
(defn parse-it [filename]
  (baizen/parse filename))
```

What's returned from `baizen/parse` is a Vector of Maps representing
each record in the file.

More documentation can be found on the
[wiki](https://github.com/testdouble/baizen/wiki).

## Development

Running the tests:

```
$ lein test
```

(assumes Leiningen 2.x)

## Documentation

More documentation can be found on the [wiki](https://github.com/testdouble/baizen/wiki).

## License

Copyright © 2014 Test Double

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
