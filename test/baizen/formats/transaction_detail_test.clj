(ns baizen.formats.transaction-detail-test
  (:require [clojure.test :refer :all]
            [baizen.formats :refer :all]
            [baizen.formats.transaction-detail :refer :all])
  (:import [baizen.formats.transaction_detail TransactionDetail]))

(deftest transaction-detail-test
  (testing "transaction detail fields"
    (let [transaction-detail-line ["16" "165" "1500000" "1" "DD1620" "DASD1234" "DEALER PAYMENTS"]
          transaction-detail (dissect (TransactionDetail. transaction-detail-line))]
      (is (= "16" (:record-code transaction-detail)))
      (is (= "165" (:type-code transaction-detail)))
      (is (= "1500000" (:amount transaction-detail)))
      (is (= "1" (:funds-type transaction-detail)))
      (is (= "DD1620" (:bank-reference-number transaction-detail)))
      (is (= "DASD1234" (:customer-reference-number transaction-detail)))
      (is (= "DEALER PAYMENTS" (:text transaction-detail)))))

  (testing "strip the slash from the customer-reference-number"
    (let [transaction-detail-line ["16" "175" "000000000346685" "Z" "00087829876" "Miami/"]
          transaction-detail (dissect (TransactionDetail. transaction-detail-line))]
      (is (= "Miami" (:customer-reference-number transaction-detail)))))

  (testing "type S funds-type changes record fields"
    (let [transaction-detail-line ["16" "115" "10000000" "S" "5000000" "4000000" "1000000" "DD1620" "DASD1234" "DEALER PAYMENTS"]
          transaction-detail (dissect (TransactionDetail. transaction-detail-line))]
      (is (= "5000000" (:immeditate-availibility-amount transaction-detail)))
      (is (= "4000000" (:oneday-availibility-amount transaction-detail)))
      (is (= "1000000" (:morethanoneday-availibility-amount transaction-detail))))))
