(ns baizen.formats.file-header-test
    (:require [clojure.test :refer :all]
              [baizen.formats :refer :all]
              [baizen.formats.file-header :refer :all])
    (:import [baizen.formats.file_header FileHeader]))

(def file-header-line ["01" "021000018" "55287" "051025" "0600" "1" "80" "080" "2/"])

(deftest file-header-test
  (testing "file header fields"
    (let [file-header (dissect (FileHeader. file-header-line))]
      (is (= "File Header" (:record-name file-header)))
      (is (= "021000018" (:sender-id file-header)))
      (is (= "55287" (:receiver-id file-header)))
      (is (= "051025" (:creation-date file-header)))
      (is (= "0600" (:creation-time file-header)))
      (is (= "1" (:file-id file-header)))
      (is (= "80" (:record-length file-header)))
      (is (= "080" (:block-size file-header)))
      (is (= "2" (:version file-header))))))
