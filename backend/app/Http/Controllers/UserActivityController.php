<?php

namespace App\Http\Controllers;

use App\Models\UserActivity;
use Illuminate\Http\Request;

class UserActivityController extends Controller
{
    public function index()
    {
        return response()->json(UserActivity::with(['user', 'activity'])->get());
    }

    public function store(Request $request)
    {
        $userActivity = UserActivity::create($request->all());
        $activity = $userActivity->activity;
        $user = $userActivity->user;

        if ($userActivity->is_correct) {
            $user->score += $activity->points;
            $user->save();
        }

        $userActivity->is_completed = true;
        $userActivity->save();
        return response()->status(201);
    }

    public function show(string $userId) {
        return response()->json(UserActivity::with(['user', 'activity'])->where('user_id', $userId)->get());
    }
}
