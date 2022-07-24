package com.example.holybibleapp.core

/**
 * @author Karapetyan on 24.07.2022
 */

abstract class Abstract {
    abstract  class Object<T, M:Mapper>{
        abstract fun map(mapper:M):T
    }

    interface Mapper{
        class Empty:Mapper
    }
}