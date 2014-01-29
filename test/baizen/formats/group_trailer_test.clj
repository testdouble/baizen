(ns baizen.formats.group-trailer-test
  (:require [clojure.test :refer :all]
            [baizen.formats :refer :all]
            [baizen.formats.group-trailer :refer :all])
  (:import (baizen.formats.group_trailer GroupTrailer)))

(def group-trailer-line ["98" "11800000" "2" "6/"])

(deftest group-trailer-test
  (testing "group trailer fields"
    (let [group-trailer (dissect (GroupTrailer. group-trailer-line))]
      (is (= "98" (:record-code group-trailer)))
      (is (= "11800000" (:group-control-total group-trailer)))
      (is (= "2" (:number-of-accounts group-trailer)))
      (is (= "6" (:number-of-records group-trailer))))))
