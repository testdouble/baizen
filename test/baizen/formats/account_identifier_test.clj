(ns baizen.formats.account-identifier-test
  (:require [clojure.test :refer :all]
            [baizen.formats :refer :all]
            [baizen.formats.account-identifier :refer :all])
  (:import [baizen.formats.account_identifier AccountIdentifier]))

(def account-identifier-line ["03" "0975312468" nil "010" "500000" nil nil "190" "70000000" "4" "0/"])

(deftest account-identifier-test
  (testing "account identifier fields"
    (let [account-identifier (dissect (AccountIdentifier. account-identifier-line))])))
