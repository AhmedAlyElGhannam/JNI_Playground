#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_lab_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}
extern "C"
JNIEXPORT void JNICALL
Java_com_example_lab_FactorialHelperJava_calcFactorial(JNIEnv *env, jclass clazz, jint num) {
    jlong res = 1;

    while (num)
    {
        res *= num;
        num--;
    }

    jmethodID cbf = (*env).GetStaticMethodID(clazz, "showResultsOnApp", "(J)V");

    (*env).CallStaticVoidMethod(clazz, cbf, res);
}