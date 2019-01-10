//package com.yly.test
//
//import com.android.build.api.transform.QualifiedContent
//import com.android.build.api.transform.Transform
//import com.android.build.api.transform.TransformException
//import com.android.build.api.transform.TransformInvocation
//import groovy.transform.CompileStatic
//import org.gradle.internal.impldep.org.eclipse.jgit.annotations.NonNull
//
//@CompileStatic
//class TestTransform extends Transform {
//
//    @Override
//    String getName() {
//        return "TestTransform"
//    }
//
//    @Override
//    Set<QualifiedContent.ContentType> getInputTypes() {
//        return Collections.<QualifiedContent.ContentType> singleton(QualifiedContent.DefaultContentType.CLASSES)
//    }
//
//    @Override
//    Set<QualifiedContent.Scope> getScopes() {
//        return Collections.singleton(QualifiedContent.Scope.PROJECT)
//    }
//
//    @Override
//    boolean isIncremental() {
//        return false
//    }
//
//    @Override
//    void transform(
//            @NonNull TransformInvocation transformInvocation) throws TransformException, InterruptedException, IOException {
//        println "TestTransform  TransformInvocation"
//        super.transform(transformInvocation)
//    }
//
//
//}