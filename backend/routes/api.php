<?php

use App\Http\Controllers\ActivityController;
use App\Http\Controllers\ModuleController;
use App\Http\Controllers\UserActivityController;
use App\Http\Controllers\UserController;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;

Route::get('/user', function (Request $request) {
    return $request->user();
})->middleware('auth:sanctum');

Route::get('/modules', [ModuleController::class, 'index']);
Route::post('/modules', [ModuleController::class, 'store']);
Route::get('/modules/{id}', [ModuleController::class, 'show']);
Route::put('/modules/{id}', [ModuleController::class, 'update']);
Route::delete('/modules/{id}', [ModuleController::class, 'destroy']);

Route::get('/activities', [ActivityController::class, 'index']);
Route::post('/activities', [ActivityController::class, 'store']);
Route::get('/activities/{id}', [ActivityController::class, 'show']);
Route::put('/activities/{id}', [ActivityController::class, 'update']);
Route::delete('/activities/{id}', [ActivityController::class, 'destroy']);

Route::get('/users/{id}', [UserController::class, 'show']);

Route::post('/user-activities', [UserActivityController::class, 'store']);
Route::get('/user-activities', [UserActivityController::class, 'index']);
Route::get('/user-activities/{userId}', [UserActivityController::class, 'show']);

Route::post('/login', [UserController::class, 'login']);