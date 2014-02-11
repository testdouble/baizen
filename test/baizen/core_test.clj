(ns baizen.core-test
  (:require [clojure.test :refer :all]
            [baizen.core :refer :all])
  (:import [java.io StringReader]))

(def bai-continuation-lines
  [["16" "115" "10000000" "S" "5000000" "4000000" "1000000/"]
   ["88" "AX13612" "B096132" "AMALGAMATED CORP. LOCKBOX"]])

(deftest preprocess-continuations-test
  (testing "removes 88 records"
    (let [[new-line] (preprocess bai-continuation-lines)]
      (is (= ["16" "115" "10000000" "S" "5000000" "4000000" "1000000" "AX13612" "B096132" "AMALGAMATED CORP. LOCKBOX"]
             new-line)))))
