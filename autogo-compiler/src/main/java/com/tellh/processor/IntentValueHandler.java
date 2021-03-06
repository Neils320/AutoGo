package com.tellh.processor;

import com.autogo.annotation.IntentValue;
import com.tellh.brewer.AutoGoClassCodeBrewer;
import com.tellh.brewer.CodeBrewer;
import com.tellh.brewer.LaunchActivityIntentCodeBrewer;
import com.tellh.entity.IntentKeyValueEntity;
import com.tellh.entity.KeyValueEntity;
import com.tellh.entity.KeyValueGroup;

import java.lang.annotation.Annotation;
import java.util.List;

import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.VariableElement;

/**
 * Created by tlh on 2016/8/2.
 */
public class IntentValueHandler extends BaseAnnotationHandler {

    public IntentValueHandler(ProcessingEnvironment processingEnv) {
        super(processingEnv);
    }

    @Override
    protected CodeBrewer newCodeBrewer() {
        return new LaunchActivityIntentCodeBrewer(mFileUtils, mElementUtils, mMessager);
    }

    @Override
    protected void buildAutoGoBrewer(AutoGoClassCodeBrewer.Builder autoGoBrewerBuilder, List<KeyValueGroup> targets) {
        autoGoBrewerBuilder.launchActivityMethods(targets);
    }

    @Override
    protected KeyValueEntity getKeyValueEntity(VariableElement variableElement) {
        return new IntentKeyValueEntity(variableElement);
    }

    @Override
    protected Class<? extends Annotation> getAnnotationClass() {
        return IntentValue.class;
    }

}
