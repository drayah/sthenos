(ns sthenos.training.domain.validations)

(def min-lengths {:training.exercise/name 3})

(defn min-length? [attribute-name]
  #(>= (count %) (attribute-name min-lengths)))
