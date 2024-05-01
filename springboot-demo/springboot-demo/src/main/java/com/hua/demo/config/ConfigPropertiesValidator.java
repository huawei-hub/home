package com.hua.demo.config;


import com.hua.demo.dto.AppConfigProperties;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * 该配置类用于校验配置类AppConfigProperties的成员变量的值的规则
 */
public class ConfigPropertiesValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return AppConfigProperties.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        AppConfigProperties config = (AppConfigProperties) o;
        if(StringUtils.isEmpty(config.getId())){
            errors.rejectValue("id", "app.id.empty", "[app.id] 属性必须要在配置文件配置");
        }else if (config.getId().length() < 5) {
            errors.rejectValue("id", "app.id.short", "[app.id] 属性的长度必须不能小于5");
        }
    }
}
