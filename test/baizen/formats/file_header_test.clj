(ns baizen.formats.file-header-test
    (:require [clojure.test :refer :all]
              [baizen.formats :refer :all]
              [baizen.formats.file-header :refer :all])
    (:import [baizen.formats.file_header FileHeader]))

(def file-header-line ["01" "021000018" "55287" "051025" "0600" "1" "80" "080" "2/"])

(deftest file-header-test
  (testing "file header fields"
    (let [file-header (dissect (FileHeader. file-header-line))]
      (is (= "File Header" (get file-header :record-name)))
      (is (= "021000018" (get file-header :sender-id)))
      (is (= "55287" (get file-header :receiver-id)))
      (is (= "051025" (get file-header :creation-date)))
      (is (= "0600" (get file-header :creation-time)))
      (is (= "1" (get file-header :file-id)))
      (is (= "80" (get file-header :record-length)))
      (is (= "080" (get file-header :block-size)))
      (is (= "2" (get file-header :version))))))
