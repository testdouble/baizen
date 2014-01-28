(ns baizen.formats.transaction-detail-test
  (:require [clojure.test :refer :all]
            [baizen.formats :refer :all]
            [baizen.formats.transaction-detail])
  (:import [baizen.formats.transaction_detail TransactionDetail]))

(def transaction-detail-line ["16" "165" "1500000" "1" "DD1620" "DASD1234" "DEALER PAYMENTS"])

(deftest transaction-detail-test
  (testing "transactiondetail fields"
    (let [transaction-detail (dissect (TransactionDetail. transaction-detail-line))]
      (is (= "16" (:record-code transaction-detail)))
      (is (= "165" (:type-code transaction-detail)))
      (is (= "1500000" (:amount transaction-detail)))
      (is (= "1" (:funds-type transaction-detail)))
      (is (= "DD1620" (:bank-reference-number transaction-detail)))
      (is (= "DASD1234" (:customer-reference-number transaction-detail)))
      (is (= "DEALER PAYMENTS" (:text transaction-detail))))))
