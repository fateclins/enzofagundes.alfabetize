<?php

namespace App\Http\Controllers;

use App\Models\Module;
use Illuminate\Http\Request;

class ModuleController extends Controller
{
    /**
     * Display a listing of the resource.
     */
    public function index()
    {
        return response()->json(Module::with('activities')->get());
    }

    /**
     * Store a newly created resource in storage.
     */
    public function store(Request $request)
    {
        $module = Module::create($request->all());
        return response()->json(['module' => $module]);
    }

    /**
     * Display the specified resource.
     */
    public function show(string $id)
    {
        $module = Module::with('activities')->find($id);
        return response()->json(['module' => $module]);
    }

    /**
     * Update the specified resource in storage.
     */
    public function update(Request $request, string $id)
    {
        $module = Module::find($id);
        $module->update($request->all());
        return response()->json(['module' => $module]);
    }

    /**
     * Remove the specified resource from storage.
     */
    public function destroy(string $id)
    {
        $module = Module::find($id);
        $module->delete();
        return response()->json(['message' => 'Module deleted']);
    }
}
