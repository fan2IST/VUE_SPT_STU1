<template>
  <div>
    <el-container style="height: 100%; ">
      <el-aside :width="sideWidth+'px'" style="background-color: rgb(238, 241, 246);height: 100vh">
        <el-menu :default-openeds="['1', '3']" style="min-height: 100%;overflow-x: hidden" background-color="rgb(48,65,86)" text-color="#fff" active-text-color="#ffd04b" :collapse-transition="false" :collapse="isCollapse">
          <div style="height: 60px;line-height: 60px;text-align: center;">
            <img src="../assets/logo.png" style="width:20px ;position: relative;top:5px">
            <b style="color: white;">
              后台管理
            </b>

          </div>
          <el-submenu index="1">
            <template slot="title">
              <i class="el-icon-message"></i>
              <span>导航一</span>
            </template>
            
            <el-submenu index="1-4">
              <template slot="title">选项4</template>
              <el-menu-item index="1-4-1">选项4-1</el-menu-item>
            </el-submenu>
          </el-submenu>
          <el-submenu index="2">
            <template slot="title"><i class="el-icon-menu"></i><span>导航二</span></template>
            
            <el-submenu index="2-4">
              <template slot="title">选项4</template>
              <el-menu-item index="2-4-1">选项4-1</el-menu-item>
            </el-submenu>
          </el-submenu>
          <el-submenu index="3">
            <template slot="title"><i class="el-icon-setting"></i><span>导航三</span></template>
            
            <el-submenu index="3-4">
              <template slot="title">选项4</template>
              <el-menu-item index="3-4-1">选项4-1</el-menu-item>
            </el-submenu>
          </el-submenu>
        </el-menu>
      </el-aside>

      <el-container>
        <el-header style="text-align: left; font-size: 12px; border-bottem:1px solid #ccc;line-height: 60px;display: flex ">
          <div style="flex: 1;font-size: 18px;">
          <span :class="collapseBtnClass" style="cursor: pointer" @click="collapse"></span>
          </div>
          <!-- 右上角下拉栏 -->
          <el-dropdown style="width: 70px">
            <span>fanIST</span>
            <i class="el-icon-arrow-down"></i>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item>个人信息</el-dropdown-item>
              <el-dropdown-item>退出</el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
          
        </el-header>

        <el-main>

          <div style="margin-bottom: 30px;">
          <el-breadcrumb separator="/">
            <el-breadcrumb-item :to="{path:'/'}">首页</el-breadcrumb-item>
            <el-breadcrumb-item>用户管理</el-breadcrumb-item>
          </el-breadcrumb>
          </div>

          <!-- 上方搜索框 -->
          <div style="padding: 10px 0">
            <el-input style="width:200px" placeholder="请输入名称" suffix-icon="el-icon-search"></el-input>
            <el-input style="width:200px" placeholder="请输入邮箱" suffix-icon="el-icon-message" class="ml-5"></el-input>
            <el-input style="width:200px" placeholder="请输入地址" suffix-icon="el-icon-position" class="ml-5"></el-input>
            <el-button class="ml-5" type="primary">搜索</el-button>
          </div>
          <!-- 前三个按钮 -->
          <div style="margin:10px 0">
            <el-button type="primary"><i class="el-icon-circle-plus-outline">新增</i></el-button>
            <el-button type="danger"><i class="el-icon-remove-outline">批量删除</i></el-button>
            <el-button type="primary"><i class="el-icon-bottom">导入</i></el-button>
            <el-button type="primary"><i class="el-icon-top">导出</i></el-button>
          </div>

          <el-table :data="tableData" border stripe header-row-class-name="headClass">
            <el-table-column prop="date" label="日期" width="140">
            </el-table-column>
            <el-table-column prop="name" label="姓名" width="120">
            </el-table-column>
            <el-table-column prop="address" label="地址">
            </el-table-column>
            <el-table-column>
              <template slot-scope="{}">
                <el-button type="success">编辑 <i class="el-icon-edit"></i></el-button>
                <el-button type="danger">删除<i class="el-icon-remove-outline"></i></el-button>
              </template>
            </el-table-column>
          </el-table>
          <!-- 分页栏位 -->

          <div style="padding: 10px 0">
            <el-pagination 
            :page-sizes="[5,10,15,20]"
            :page-size="10"
            layout="total,sizes,prev,pager,next,jumper"
            :total="400">
            </el-pagination>
          </div>

          
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'
import { Collapse } from 'element-ui';

export default {
  name: 'HomeView',
  components: {
    HelloWorld
  },
  data(){
    const item = {
      date: '2019-05-02',
      name: 'banana',
      address: '上海市普陀区金沙江路 1518 弄'
    };

    return{
      msg:"hello banana",
      tableData: Array(10).fill(item),
      collapseBtnClass:'el-icon-s-fold',
      isCollapse:false,
      sideWidth:200
    }
    },
    methods:{
      collapse(){
        this.isCollapse = !this.isCollapse
        if(this.isCollapse){
          this.sideWidth =64
          this.collapseBtnClass = 'el-icon-s-unfold'
        }else{
          this.sideWidth =200
          this.collapseBtnClass ='el-icon-s-fold'

        }

        }

      }
    }
</script>
