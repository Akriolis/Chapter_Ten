import ru.yole.jkid.deserialization.deserialize
import ru.yole.jkid.serialization.serialize
import kotlin.reflect.KFunction
import kotlin.reflect.full.memberProperties

/**
 * Annotations and reflections
 */

@Deprecated("Use removeAt(index) instead.", ReplaceWith("removeAt(index)"))

fun remove(index: Int){

}

/**
 * Annotation targets
 */

/**
 * Serialization is a process of converting an object to a binary or text representation
 * that can be then stored or sent over the network
 *
 * reverse process - deserialization
 */

/**
 * annotation class AnyClassThatYouCanImagine (val any: Any)
 */

/**
 * @JsonName (name = "first_name") the same as @JsonName("first_name")
 */

/**
 * meta-annotations
 */

@Target(AnnotationTarget.PROPERTY)
annotation class JsonExclude

@Target(AnnotationTarget.ANNOTATION_CLASS)
annotation class BindingAnnotation

@BindingAnnotation
annotation class MyBinding

/**
 * Classes as annotation parameters
 */

/**
 * Generic classes as annotation parameters
 */

/**
 * Reflections: introspecting Kotlin objects at runtime
 */

/**
 * Kotlin reflection API
 */

fun foo(x: Int) = println(x)

fun sum(x: Int, y: Int) = x + y

/**
 * Implementing object serialization using reflection
 */

/**
 * Customizing serialization with annotations
 */

/**
 * JSON parsing and object deserialization
 */

data class Author (val name: String)
data class Book (val title: String, val author: Author)

fun main(){
    val person = Person("Alice", 29)
    println(serialize(person))

    val serializablePerson = serialize(person)
    println(serializablePerson)

    val json = """{"alias": "Alice", "age":29}"""
    println(deserialize<Person>(json))

    val deSerPerson = deserialize<Person>(serializablePerson)
    println(deSerPerson)

    val anotherPerson = Person("Alice", 29)
    val kClass = anotherPerson.javaClass.kotlin

    println(kClass.simpleName)
    kClass.memberProperties.forEach { println(it.name) }

    val kFunction = ::foo
    kFunction.call(42)

    val randomKFun= ::sum
    println(randomKFun.invoke(1,2) + randomKFun(3,4))

    val memberProperty = Person::age
    println(memberProperty.get(anotherPerson))

    val json2 = """{"title": "Catch-22", "author": {"name": "J. Heller"}} """
    val book = deserialize<Book>(json2)
    println(book)

    




}