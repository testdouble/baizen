(ns baizen.formats.group-header-test
  (:require [clojure.test :refer :all]
            [baizen.formats :refer :all]
            [baizen.formats.group-header :refer :all])
  (:import [baizen.formats.group_header GroupHeader]))

(def group-header-line ["02" "031001234" "122099999" "1" "040620" "2359" "GBP" "2/"])

(deftest group-header-test
  (testing "group header fields"
    (let [group-header (dissect (GroupHeader. group-header-line))]
      (is (= "02" (:record-code group-header)))
      (is (= "031001234" (:receiver-id group-header)))
      (is (= "122099999" (:originator-id group-header)))
      (is (= "1" (:group-status group-header)))
      (is (= "040620" (:as-of-date group-header)))
      (is (= "2359" (:as-of-time group-header)))
      (is (= "GBP" (:currency-code group-header)))
      (is (= "2" (:as-of-date-modifier group-header)))))

  (testing "default currency code is USD"
    (let [group-header-line (assoc group-header-line 6 nil)
          group-header (dissect (GroupHeader. group-header-line))]
      (is (= "USD" (:currency-code group-header))))))
