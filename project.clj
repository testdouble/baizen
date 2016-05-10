(defproject baizen "0.6.0-SNAPSHOT"
  :description "BAI file format parser"
  :url "https://github.com/testdouble/baizen"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1" :scope "provided"]
                 [org.clojure/data.csv "0.1.3"]
                 [org.clojure/core.match "0.2.2"]]
  :profiles {:dev {:resource-paths ["test-resources"]}
             :1.5 {:resource-paths ["test-resources"]
                   :dependencies [[org.clojure/clojure "1.5.1" :scope "provided"]]}
             :1.6 {:resource-paths ["test-resources"]
                   :dependencies [[org.clojure/clojure "1.6.0" :scope "provided"]]}
             :1.7 {:resource-paths ["test-resources"]
                   :dependencies [[org.clojure/clojure "1.7.0" :scope "provided"]]}
             :1.8 {:resource-paths ["test-resources"]
                   :dependencies [[org.clojure/clojure "1.8.0" :scope "provided"]]}}
  :aliases {"test-all-profiles" ["with-profile" "dev:1.5:1.6:1.7:1.8" "test"]})
