(ns baizen.formats.file-trailer-test
  (:require [clojure.test :refer :all]
            [baizen.formats :refer :all]
            [baizen.formats.file-trailer :refer :all])
  (:import (baizen.formats.file_trailer FileTrailer)))

(def file-trailer-line ["99" "1215450000" "4" "36/"])

(deftest file-trailer-test
  (testing "file trailer fields"
    (let [file-trailer (dissect (FileTrailer. file-trailer-line))]
      (is (= "99" (:record-code file-trailer)))
      (is (= "1215450000" (:file-control-total file-trailer)))
      (is (= "4" (:number-of-groups file-trailer)))
      (is (= "36" (:number-of-records file-trailer))))))
