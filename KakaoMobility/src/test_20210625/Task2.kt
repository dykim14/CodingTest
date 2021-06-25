package test_20210625

import java.util.*
import kotlin.collections.LinkedHashMap


class Task2 {

}

data class Student(val id: Id, val name: String, val subscribedCourses: List<Course>)
data class Course(val id: Id, val name: String, val isPaid: Boolean)

typealias Id = Int

interface Repository<T> {
    fun get(): Iterable<T>
}

class University(private val repository: Repository<Student>) {
    fun getPaidCoursesWithTheNumbersOfSubscribedStudents(coursesCount: Int): Map<Course, Int> {
        val map = HashMap<Course, Int>();
        repository.get().forEach {
            it ->
            val courses = it.subscribedCourses
            courses.forEach {
                if (it.isPaid) {
                    map[it] = map.getOrDefault(it, 0) + 1
                }
            }

        }
        // println(map)
        val entries = LinkedList<Map.Entry<Course, Int>>(map.entries)
        Collections.sort(entries, kotlin.Comparator { o1, o2 -> o2.value.compareTo(o1.value) })
        val result = LinkedHashMap<Course, Int>()
        entries.forEachIndexed { index, entry ->
            if (index < coursesCount) {
                result[entry.key] = entry.value
            }
        }
        // println(result)
        return result
    }
}