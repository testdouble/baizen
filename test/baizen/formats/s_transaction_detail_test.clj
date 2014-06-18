(ns baizen.formats.s-transaction-detail-test
  (:require [clojure.test :refer :all]
            [baizen.formats :refer :all]
            [baizen.formats.s-transaction-detail :refer :all])
  (:import [baizen.formats.s_transaction_detail STransactionDetail]))

(deftest s-transaction-detail-test
  (testing "S transaction detail fields"
    (let [transaction-detail-line ["16" "115" "10000000" "S" "5000000" "4000000" "1000000" "DD1620" "DASD1234" "DEALER PAYMENTS"]
          transaction-detail (dissect (STransactionDetail. transaction-detail-line))]
      (is (= "16" (:record-code transaction-detail)))
      (is (= {:code "115" :transaction "CR" :level "Detail" :description "Lockbox Deposit"}
             (:type-code transaction-detail)))
      (is (= "10000000" (:amount transaction-detail)))
      (is (= "S" (:funds-type transaction-detail)))
      (is (= "5000000" (:immediate-availability-amount transaction-detail)))
      (is (= "4000000" (:oneday-availability-amount transaction-detail)))
      (is (= "1000000" (:morethanoneday-availability-amount transaction-detail)))
      (is (= "DD1620" (:bank-reference-number transaction-detail)))
      (is (= "DASD1234" (:customer-reference-number transaction-detail)))
      (is (= "DEALER PAYMENTS" (:text transaction-detail)))))

  (testing "strip the slash from the customer-reference-number"
    (let [transaction-detail-line ["16" "115" "10000000" "S" "5000000" "4000000" "1000000" "DD1620" "Miami/"]
          transaction-detail (dissect (STransactionDetail. transaction-detail-line))]
      (is (= "Miami" (:customer-reference-number transaction-detail))))))
