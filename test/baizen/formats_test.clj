(ns baizen.formats-test
  (:require [clojure.test :refer :all]
            [baizen.formats :refer :all]))

(deftest ?assoc-test
  (testing "only assoc values that are currently null in the map"
    (let [m {:a 1 :b nil}]
      (is (= {:a 1 :b nil} (?assoc m :a 2)))
      (is (= {:a 1 :b 2} (?assoc m :b 2)))))

  (testing "assoc value if key doesn't exist in the map"
    (let [m {:a 1}]
      (is (= {:a 1 :b 2} (?assoc m :b 2))))))
