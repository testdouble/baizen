(ns baizen.dissect-test
  (:require [clojure.test :refer :all]
            [baizen.dissect :refer :all]))

(deftest dissect-line-test
  (testing "file-header"
    (let [file-header-line ["01" "021000018" "55287" "051025" "0600" "1" "80" "080" "2/"]
          dissected (dissect-line file-header-line)]
      (is (= "01" (:record-code dissected)))))

  (testing "group-header"
    (let [group-header-line ["02" "031001234" "122099999" "1" "040620" "2359" nil "2/"]
          dissected (dissect-line group-header-line)]
      (is (= "02" (:record-code dissected)))))

  (testing "account-identifier"
    (let [account-identifier-line ["03" "0975312468" nil "010" "500000" nil "0/"]
          dissected (dissect-line account-identifier-line)]
      (is (= "03" (:record-code dissected)))))

  (testing "transaction-detail"
    (let [transaction-detail-line ["16" "165" "1500000" "1" "DD1620" nil "DEALER PAYMENTS"]
          dissected (dissect-line transaction-detail-line)]
      (is (= "16" (:record-code dissected)))))

  (testing "continuation-record")

  (testing "account-trailer"
    (let [account-trailer-line ["49" "18650000" "3/"]
          dissected (dissect-line account-trailer-line)]
      (is (= "49" (:record-code dissected)))))

  (testing "group-trailer"
    (let [group-trailer-line ["98" "11800000" "2" "6/"]
          dissected (dissect-line group-trailer-line)]
      (is (= "98" (:record-code dissected))))))
