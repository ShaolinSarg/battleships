(defproject oc_battleships "0.1.0-SNAPSHOT"
  :description "FIXME: write description"

  :url "http://example.com/FIXME"

  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[org.clojure/clojure "1.10.0"]
                 [compojure "1.6.1"]
                 [ring/ring-defaults "0.3.2"]
                 [ring/ring-json "0.4.0"]
                 [cheshire "5.8.1"]
                 [com.taoensso/timbre "4.10.0"]
                 [buddy/buddy-auth "2.1.0"]]

  :target-path "target/%s"

  :plugins [[lein-ring "0.12.4"]]

  :ring {:handler oc-battleships.web/app}

  :profiles {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                                  [ring/ring-mock "0.3.2"]]}

             :uberjar {:aot :all}})
