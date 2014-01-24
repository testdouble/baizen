(ns baizen.dissect-test
  (:require [clojure.test :refer :all]
            [baizen.dissect :refer :all]))

(def first-line ["01" "021000018" "55287" "051025" "0600" "1" "80" "080" "2/                "])

(deftest dissect-line-test
  (testing "first line of BAI file"
    (let [dissected (dissect-line first-line)]
      (is (= "File Header" (get dissected :record-name)))
      (is (= "021000018" (get dissected :sender-id)))
      (is (= "55287" (get dissected :receiver-id)))
      (is (= "051025" (get dissected :creation-date)))
      (is (= "0600" (get dissected :creation-time)))
      (is (= "1" (get dissected :file-id)))
      (is (= "80" (get dissected :record-length)))
      (is (= "080" (get dissected :block-size)))
      (is (= "2" (get dissected :version)))))

  (testing "first line without optional fields"))
