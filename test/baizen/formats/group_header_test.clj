(ns baizen.formats.group-header-test
  (:require [clojure.test :refer :all]
            [baizen.formats :refer :all])
  (:import [baizen.formats GroupHeader]))

(def group-header-line ["02" "031001234" "122099999" "1" "040620" "2359" "GBP" "2/"])

(deftest group-header-test
  (testing "group header fields"
    (let [group-header (dissect (GroupHeader. group-header-line))]
      (is (= "Group Header" (get group-header :record-name)))
      (is (= "031001234" (get group-header :receiver-id)))
      (is (= "122099999" (get group-header :originator-id)))
      (is (= "1" (get group-header :group-status)))
      (is (= "040620" (get group-header :as-of-date)))
      (is (= "2359" (get group-header :as-of-time)))
      (is (= "GBP" (get group-header :currency-code)))
      (is (= "2" (get group-header :as-of-date-modifier)))))

  (testing "default currency code is USD"
    (let [group-header-line (assoc group-header-line 6 nil)
          group-header (dissect (GroupHeader. group-header-line))]
      (is (= "USD" (get group-header :currency-code))))))
