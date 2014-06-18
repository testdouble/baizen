(ns baizen.formats.account-identifier-test
  (:require [clojure.test :refer :all]
            [baizen.formats :refer :all]
            [baizen.formats.account-identifier :refer :all])
  (:import [baizen.formats.account_identifier AccountIdentifier]))

(def simple-account-identifier-line
  ["03" "0975312468" "GBP"
   "010" "500000" "1" "0/"])

(def account-identifier-line-with-multiple-summaries
  ["03" "0975312468" "GBP"
   "010" "500000" "1" "0"
   "056" "2000"   "" "0"
   "057" "4000"   "" "2/"])

(deftest account-identifier-test
  (testing "account identifier fields"
    (testing "with only one summary"
      (let [account-identifier (dissect (AccountIdentifier. simple-account-identifier-line))
            summary (first (:summaries account-identifier))]
        (is (= "03" (:record-code account-identifier)))
        (is (= "0975312468" (:customer-account-number account-identifier)))
        (is (= "GBP" (:currency-code account-identifier)))
        (is (= {:code "010" :transaction "NA" :level "Status" :description "Opening Ledger"}
               (:type-code summary)))
        (is (= "500000" (:amount summary)))
        (is (= "1" (:item-count summary)))
        (is (= "0" (:funds-type summary)))))

    (testing "with multiple summaries"
      (let [account-identifier (dissect (AccountIdentifier. account-identifier-line-with-multiple-summaries))
            first-summary (first (:summaries account-identifier))
            second-summary (second (:summaries account-identifier))
            third-summary (last (:summaries account-identifier))]
        (is (= "03" (:record-code account-identifier)))
        (is (= "0975312468" (:customer-account-number account-identifier)))
        (is (= "GBP" (:currency-code account-identifier)))

        (is (= {:code "010" :transaction "NA" :level "Status" :description "Opening Ledger"}
               (:type-code first-summary)))
        (is (= "500000" (:amount first-summary)))
        (is (= "1" (:item-count first-summary)))
        (is (= "0" (:funds-type first-summary)))

        (is (= {:code "056" :transaction "NA" :level "Status" :description "Loan Balance"}
               (:type-code second-summary)))
        (is (= "2000" (:amount second-summary)))
        (is (= "" (:item-count second-summary)))
        (is (= "0" (:funds-type second-summary)))

        (is (= {:code "057" :transaction "NA" :level "Status" :description "Total Investment Position"}
               (:type-code third-summary)))
        (is (= "4000" (:amount third-summary)))
        (is (= "" (:item-count third-summary)))
        (is (= "2" (:funds-type third-summary))))))

  (testing "default :current-code should be the same as the group currency code")
  (testing "default :item-count is 'unknown'")
  (testing "default :funds-type is 'Z'")
  (testing "handle :funds-type is 'D' -- there will be extra records"))
