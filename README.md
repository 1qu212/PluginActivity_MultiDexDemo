# PluginActivity_MultiDexDemo
通过合并多个dex加载插件中的类

# 同样只适配到API25
更多适配见[Android插件化的兼容性（上）：Android O的适配](https://www.cnblogs.com/Jax/p/9521298.html)

[Android插件化的兼容性（中）：Android P的适配](https://www.cnblogs.com/Jax/p/9521305.html)

[Android插件化的兼容性（下）：突破Android P中灰黑名单的限制](https://www.cnblogs.com/Jax/p/9521335.html)

# 方案步骤
step1：通过反射把插件dex和宿主dexElements合并成一个新的dex数组，替换宿主之前的dexElements字段；

step2：对ActivityManagerNative的getDefault()方法进行Hook，把TargetActivity替换为StubActivity；

step3：对H类的mCallback字段进行Hook，拦截它的handleMessage()方法，把StubActivity再替换回TargetActivity。

# 方案优势
相较于[PluginAcitivityDemo](https://github.com/1qu212/PluginAcitivityDemo)方案，插件中activity的加载不需要特地指明使用该插件的ClassLoader。
