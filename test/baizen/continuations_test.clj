(ns baizen.continuations-test
  (:require [clojure.test :refer :all]
            [baizen.continuations :refer :all])
  (:import [java.io StringReader]))

(deftest preprocess-continuations-test
  (testing "removes 88 records"
    (let [[new-line] (preprocess [["16" "115" "10000000" "S" "5000000" "4000000" "1000000/"]
                                  ["88" "AX13612" "B096132" "AMALGAMATED CORP. LOCKBOX"]])]
      (is (= ["16" "115" "10000000" "S" "5000000" "4000000" "1000000" "AX13612" "B096132" "AMALGAMATED CORP. LOCKBOX"]
             new-line))))

  (testing "continuation line with a new field"
    (let [[new-line] (preprocess [["16" "475" "2197500" "" "" "00000099999" "/                                                  "]
                                  ["88" "OTHER REFERENCE:FOO"]])]
      (is (= ["16" "475" "2197500" "" "" "00000099999" "OTHER REFERENCE:FOO"]
             new-line))))

  (testing "multiple continuation lines with a new field"
    (let [[new-line] (preprocess [["16" "475" "2197500" "" "" "00000099999" "/                                                  "]
                                  ["88" "OTHER REFERENCE:FOO/                                              "]
                                  ["88" "CHECK/                                                                       "]])]
      (is (= ["16" "475" "2197500" "" "" "00000099999" "OTHER REFERENCE:FOO CHECK/                                                                       "]
             new-line)))))
