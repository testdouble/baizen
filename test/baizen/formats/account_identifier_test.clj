(ns baizen.formats.account-identifier-test
  (:require [clojure.test :refer :all]
            [baizen.formats :refer :all]
            [baizen.formats.account-identifier :refer :all])
  (:import [baizen.formats.account_identifier AccountIdentifier]))

(def account-identifier-line ["03" "0975312468" "GBP" "010" "500000" "1" "0/"])

(deftest account-identifier-test
  (testing "account identifier fields"
    (let [account-identifier (dissect (AccountIdentifier. account-identifier-line))]
      (is (= "03" (:record-code account-identifier)))
      (is (= "0975312468" (:customer-account-number account-identifier)))
      (is (= "GBP" (:currency-code account-identifier)))
      (is (= "010" (:type-code account-identifier)))
      (is (= "500000" (:amount account-identifier)))
      (is (= "1" (:item-count account-identifier)))
      (is (= "0" (:funds-type account-identifier))))

  (testing "default :current-code should be the same as the group currency code")
  (testing "default :item-count is 'unknown'")
  (testing "default :funds-type is 'Z'")))
