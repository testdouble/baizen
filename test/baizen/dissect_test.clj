(ns baizen.dissect-test
  (:require [clojure.test :refer :all]
            [baizen.dissect :refer :all]))

(def first-line ["01" "021000018" "55287" "051025" "0600" "1" "80" "080" "2/                "])

(deftest dissect-line-test
  (testing "first line of BAI file"
    (is (= "File Header"
           (get (dissect-line first-line)
                :record-name)))))
