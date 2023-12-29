# MCMod_EnChi
Minecraft mod for 1.18.2 forge.

# 部署流程
1. 下载项目，用IDEA打开
2. 启动后等待Gradle下载依赖
3. 运行Gradle中的`genIntellijRuns`任务
4. 运行Gradle中的`runClient`任务，启动游戏

# 参考资料
我的世界Minecraft 1.19 Mod开发教程分享-01-环境搭建 - 哔哩哔哩
https://www.bilibili.com/read/cv24332474/

我的世界1.19.mod开发教程#1环境配置
https://www.bilibili.com/video/BV1Dv4y187L1/

11.6 Forge 的扩展 · Harbinger
https://harbinger.covertdragon.team/chapter-11/forge-extension/

Forge 下载
https://files.minecraftforge.net/net/minecraftforge/forge/index_1.18.2.html

Forge 文档
https://docs.minecraftforge.net/en/1.18.x/gettingstarted/

Forge 中文文档
https://mcforge-cn.readthedocs.io/zh/latest/

# 版本号格式
`MCVERSION-MAJORMOD.MAJORAPI.MINOR.PATCH`

- `MCVERSION`
  - Always matches the Minecraft version the mod is for. 
    - 始终与mod所用的Minecraft版本相匹配。
- `MAJORMOD`
  - Removing items, blocks, block entities, etc. 
    - 删除物品、方块、方块实体等。
  - Changing or removing previously existing mechanics. 
    - 更改或删除先前存在的机制。
  - Updating to a new Minecraft version.
    - 更新到新的Minecraft版本。
- `MAJORAPI`
  - Changing the order or variables of enums. 
    - 修改枚举的顺序或变量。
  - Changing return types of methods. 
    - 更改方法的返回类型。
  - Removing public methods altogether.
    - 完全删除公共方法。
- `MINOR`
  - Adding items, blocks, block entities, etc. 
    - 添加物品、方块、方块实体等。
  - Adding new mechanics. 
    - 添加新的机制。
  - Deprecating public methods. (This is not a MAJORAPI increment since it doesn’t break an API.)
    - 弃用公共方法。（这不是MAJORAPI增量，因为它不会破坏API。）
- `PATCH`
  - Bugfixes.
    - 修复bug。