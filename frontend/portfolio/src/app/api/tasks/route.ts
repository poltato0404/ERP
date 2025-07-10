import { NextRequest, NextResponse } from "next/server";

export async function GET(req: NextRequest) {
  const backendUrl = `${process.env.BACKEND_API}/books`;

  console.log("[DEBUG] Fetching from:", backendUrl); // ⬅ confirm URL here

  try {
    const response = await fetch(backendUrl, {
      headers: { Accept: "application/json" },
    });

    if (!response.ok) {
      const errorText = await response.text();
      console.error("Backend error:", response.status, errorText);
      return NextResponse.json({ error: "Backend error", detail: errorText }, { status: response.status });
    }

    const data = await response.json();
    return NextResponse.json(data);
  } catch (err) {
    console.error("Fetch error:", err);
    return NextResponse.json({ error: "Failed to fetch", detail: String(err) }, { status: 500 });
  }
}
