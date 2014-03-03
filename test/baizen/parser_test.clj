(ns baizen.parser-test
  (:require [clojure.test :refer :all]
            [baizen.parser :refer :all]))

(deftest parse-line-test
  (testing "transaction-detail"
    (let [transaction-detail-line ["16" "165" "1500000" "1" "DD1620" nil "DEALER PAYMENTS"]
          dissected (parse-line transaction-detail-line)]
      (is (= "16" (:record-code dissected)))))

  (testing "s-transaction-detail"
    (let [transaction-detail-line ["16" "115" "10000000" "S" "5000000" "4000000" "1000000" "DD1620" "DASD1234" "DEALER PAYMENTS"]
          dissected (parse-line transaction-detail-line)]
      (is (= "16" (:record-code dissected))))))

(def bai-group
  [["02" "1" "2" "3" "4" "5" "6" "7/"]
   ["03" "8" "9" "10" "11" "12" "13" "14/"]
   ["16" "" "" "/"]
   ["49" "15" "16/"]
   ["98" "17" "18" "19/"]])

(def bai-groups
  (conj bai-group
   ["02" "55288" "021000018" "1" "051022" "0000" "" "/"]
   ["03" "0102000000" "" "015" "+00000004060801" "" "" "/"]
   ["16" "" "" "/"]
   ["49" "6" "7/"]
   ["98" "8" "9" "10/"]))

(deftest groups-test
  (testing "single group"
    (let [parsed-group (first (parse-groups bai-group))]
      (is (= "02" (:record-code (:group-header parsed-group))))
      (is (= "98" (:record-code (:group-trailer parsed-group))))
      (is (= "03" (:record-code (:account-identifier (first (:accounts parsed-group))))))))

  (testing "multiple groups"
    (let [parsed-groups (parse-groups bai-groups)]
      (is (= 2 (count parsed-groups))))))
