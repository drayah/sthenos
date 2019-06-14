(ns sthenos.training.domain.exercise
  (:require [clojure.spec.alpha :as s]
            [sthenos.training.domain.validations :as domain.validations]))

(s/def :training.exercise/id #{:burpee
                               :burpee-jump
                               :sprawl
                               :squat})

(s/def :training.exercise/name
  (s/and string? (domain.validations/min-length? :training.exercise/name)))

(s/def :training.exercise/movement
  (s/keys :req [:training.exercise/id
                :training.exercise/name
                :training.exercise/type
                :training.exercise/difficulty
                :training.exercise/variants]))

(def burpee-example-movement
  {:training.exercise/id         :burpee
   :training.exercise/name       "Burpees"
   :training.exercise/type       :total-body
   :training.exercise/difficulty :intermediate
   :training.exercise/variants   {:beginner :sprawl
                                  :advanced :burpee-jump}})
