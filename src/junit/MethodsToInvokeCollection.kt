package club.globalcyberspace.kotlin.starter.junit

import club.globalcyberspace.kotlin.starter.junit.annotations.MyTestMethod
import club.globalcyberspace.kotlin.starter.junit.annotations.MyTestMethodAfter
import club.globalcyberspace.kotlin.starter.junit.annotations.MyTestMethodBefore
import club.globalcyberspace.kotlin.starter.junit.annotations.MyTestMethodInit
import club.globalcyberspace.kotlin.starter.junit.exception.IllegalAnnotationException
import java.util.*
import kotlin.collections.ArrayList
import java.lang.reflect.Method

class MethodsToInvokeCollection {
    val methodsToInvoke = LinkedList<Method>()
    val methodsInit = ArrayList<Method>()

    @Throws(NoSuchMethodException::class, IllegalAnnotationException::class)
    fun setMethod(method: Method) {
        if (method.isAnnotationPresent(MyTestMethodInit::class.java)) {
            if (!methodsInit.contains(method)) {
                methodsInit.add(method)
            }
        } else if (method.isAnnotationPresent(MyTestMethod::class.java)) {
            if (methodsToInvoke.contains(method)) {
                return
            } else {
                methodsToInvoke.add(method)
            }
        } else if (method.isAnnotationPresent(MyTestMethodBefore::class.java)) {
            val current = method.declaringClass.getMethod(method.getAnnotation<MyTestMethodBefore>(MyTestMethodBefore::class.java!!).methodBefore)
            if (current.isAnnotationPresent(MyTestMethodInit::class.java)) {
                throw IllegalAnnotationException("Init method cannot has before or after methods")
            }
            if (!methodsToInvoke.contains(current)) {
                methodsToInvoke.add(current)
            }
            methodsToInvoke.add(methodsToInvoke.indexOf(current), method)
        } else if (method.isAnnotationPresent(MyTestMethodAfter::class.java)) {
            val current = method.declaringClass.getMethod(method.getAnnotation<MyTestMethodAfter>(MyTestMethodAfter::class.java!!).methodAfter)
            if (current.isAnnotationPresent(MyTestMethodInit::class.java)) {
                throw IllegalAnnotationException("Init method cannot has before or after methods")
            }
            if (!methodsToInvoke.contains(current)) {
                methodsToInvoke.add(current)
            }
            methodsToInvoke.add(methodsToInvoke.indexOf(current) + 1, method)
        }
    }
}