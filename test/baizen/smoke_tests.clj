(ns baizen.smoke-tests
  (:require [clojure.test :refer :all]
            [clojure.java.io :as io]
            [baizen.core :refer :all]))

#_(def test-file (io/reader (io/resource "BAI-File-From-Bank.bai")))
(def simple-test-file (io/reader (io/resource "BAI-File-From-Bank-Simple.bai")))

(deftest parse-test
  (testing "smoke tests -- transactions"
    (let [parsed-file (parse simple-test-file)
          txns (:transactions (first (:accounts (first (:groups parsed-file)))))]
      (is (> (count txns) 0))
      (is (not (nil? (some #(= (:amount %1) "000000000346685") txns)))))))
