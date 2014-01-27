(ns baizen.dissect-test
  (:require [clojure.test :refer :all]
            [baizen.dissect :refer :all]))

(deftest dissect-line-test
  (testing "file-header"
    (let [file-header-line ["01" "021000018" "55287" "051025" "0600" "1" "80" "080" "2/"]
          dissected (dissect-line file-header-line)]
      (is (= "File Header"
             (get dissected :record-name)))))

  (testing "group-header"
    (let [group-header-line ["02" "031001234" "122099999" "1" "040620" "2359" nil "2/"]
          dissected (dissect-line group-header-line)]
      (is (= "Group Header"
             (get dissected :record-name))))))
