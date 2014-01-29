(ns baizen.formats.account-trailer-test
  (:require [baizen.formats :refer [dissect]]
            [clojure.test :refer [deftest is testing]]
            [baizen.formats.account-trailer :refer :all])
  (:import (baizen.formats.account_trailer AccountTrailer)))

(def account-trailer-line ["49" "18650000" "3/"])

(deftest account-trailer-test
  (testing "account trailer fields"
    (let [account-trailer (dissect (AccountTrailer. account-trailer-line))]
      (is (= "49" (:record-code account-trailer)))
      (is (= "18650000" (:account-control-total account-trailer)))
      (is (= "3" (:number-of-records account-trailer))))))
