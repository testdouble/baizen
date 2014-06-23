# baizen - BAI File Parsing

A Clojure library designed to parse the Bank Administration Institute (BAI) file format.

[![Build Status](https://travis-ci.org/testdouble/baizen.png?branch=master)](https://travis-ci.org/testdouble/baizen)
[![Dependency Status](https://www.versioneye.com/user/projects/52fcfed1ec1375683f00013a/badge.png)](https://www.versioneye.com/user/projects/52fcfed1ec1375683f00013a)

More documentation can be found on the [wiki](https://github.com/testdouble/baizen/wiki).

## Reference Documentation

[BAI Version 2 Specification](http://www.bai.org/Libraries/Site-General-Downloads/Cash_Management_2005.sflb.ashx)

## Dependency Information

[Leiningen](https://github.com/technomancy/leiningen/):

```
[baizen "0.5.0"]
```

[Maven](http://maven.apache.org/):

```
<dependency>
  <groupId>baizen</groupId>
  <artifactId>baizen</artifactId>
  <version>0.5.0</version>
</dependency>
```

## Usage

from the repl

```
user=> (require '[baizen.core :as baizen])
nil
user=> (baizen/parse "test-resources/BAI-File-From-Bank-Simple.bai")
{:file-header
 {:version "2",
  :block-size "080",
  :record-length "80",
  :file-id "1",
  :creation-time "0600",
  :creation-date "051025",
  :receiver-id "55287",
  :sender-id "021000018",
  :record-code "01"},
 :groups
 [{:group-header
   {:as-of-date-modifier "",
    :currency-code "",
    :as-of-time "0000",
    :as-of-date "051022",
    :group-status "1",
    :originator-id "021000018",
    :receiver-id "55287",
    :record-code "02"},
   :accounts
   [{:account-identifier
     {:summaries
      ({:funds-type "",
        :item-count "",
        :amount "+00000004060801",
        :type-code
        {:description "Closing Ledger",
         :transaction "NA",
         :level "Status",
         :code "015"}}
       {:funds-type "",
        :item-count "",
        :amount "+00000003836014",
        :type-code
        {:description "Closing Available",
         :transaction "NA",
         :level "Status",
         :code "045"}}),
      :currency-code "",
      :customer-account-number "0101999999",
      :record-code "03"},
     :transactions
     ({:customer-reference-number "Miami",
       :bank-reference-number "00087829876",
       :funds-type "Z",
       :amount "000000000346685",
       :type-code
       {:description "Check Deposit Package",
        :transaction "CR",
        :level "Detail",
        :code "175"},
       :record-code "16"}),
     :account-trailer
     {:number-of-records "23",
      :account-control-total "000000018798558",
      :record-code "49"}}],
   :group-trailer
   {:number-of-records "32",
    :number-of-accounts "2",
    :group-control-total "000000059748918",
    :record-code "98"}}],
 :file-trailer
 {:number-of-records "34",
  :number-of-groups "1",
  :file-control-total "000000059748918",
  :record-code "99"}}
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

## Contributing

Thanks to all of our [contributors](https://github.com/testdouble/baizen/graphs/contributors).

We welcome all contributors to the project. Please submit an [Issue](https://github.com/testdouble/baizen/issues)
and a [Pull Request](https://github.com/testdouble/baizen/pulls) if you have one.

## Documentation

More documentation can be found on the [wiki](https://github.com/testdouble/baizen/wiki).

## License

Copyright © 2014 Test Double

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
