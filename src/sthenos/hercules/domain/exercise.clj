(ns sthenos.hercules.domain.exercise
  (:require [clojure.spec.alpha :as s]
            [sthenos.hercules.domain.validations :as domain.validations]))

(s/def :exercise/id #{:burpee
                      :burpee-jump
                      :sprawl
                      :squat})

(s/def :exercise/name
  (s/and string? (domain.validations/min-length? :exercise/name)))

(s/def :exercise/movement
  (s/keys :req [:exercise/id
                :exercise/name
                :exercise/type
                :exercise/difficulty
                :exercise/variants]))

(def burpee-example-movement
  {:exercise/id         :burpee
   :exercise/name       "Burpees"
   :exercise/type       :total-body
   :exercise/difficulty :intermediate
   :exercise/variants   {:beginner :sprawl
                         :advanced :burpee-jump}})
