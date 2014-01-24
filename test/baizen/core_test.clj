(ns baizen.core-test
  (:require [clojure.test :refer :all]
            [baizen.core :refer :all]))

(def test-file "test-resources/BAI-File-From-Bank.bai")

(deftest parse-test
  (testing "reading in a file returns a clojure.lang.LazySeq"
    (is (= clojure.lang.LazySeq (class (parse test-file))))))
